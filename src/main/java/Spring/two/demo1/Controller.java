package Spring.two.demo1;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cliente/v1")

public class Controller {

    @Autowired
    Repository repository;

    @PostMapping
    public Cliente create(@RequestBody @Valid Cliente cliente){
        for(Produto p : cliente.getProdutos()){
            p.setPrecoTotal(p.getPrecoUnitario()* p.getQuantidade());

        }
        Cliente clienteSaved = repository.save(cliente);
        return clienteSaved;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Cliente> getClienteById(@PathVariable Long id){
        Optional<Cliente> clienteReturned = repository.findById(id);
        return clienteReturned;
    }

    @DeleteMapping("/{id}")
    public String deleteCLienteById(@PathVariable Long id){
        try{
            Optional <Cliente> cliente = Optional.of(repository.getById(id));
            if(cliente != null){
                repository.deleteById(id);
                return "Cliente de " + id + " deletado com sucesso!";
            }else{
                throw new Exception("Cliente inexistente!");
            }
        }catch (Exception e){
            e.printStackTrace();
            return "O cliente de id: " + id + " não existe para ser deletado!" + " Por favor, entre em contato com o atendimento 888 888 888";
        }
    }

    @GetMapping
    public List<Cliente> listClientes(){
        return repository.findAll();
    }

    @PutMapping("/atualize/{id}")
    public String updateClienteById(@RequestBody @Valid ClienteDTO clienteDTO, @PathVariable Long id){
        Optional<Cliente> velhoCLiente = repository.findById(id);
        if(velhoCLiente.isPresent()){
            Cliente cliente = velhoCLiente.get();
            cliente.setEndereco(clienteDTO.getEndereçoCliente());
            repository.save(cliente);
            return "Cliente de ID " + cliente.getId() + " atualizado com sucesso!!";

        }else{
            return "CLiente de ID " + id + " não existe";
        }

    }

}
