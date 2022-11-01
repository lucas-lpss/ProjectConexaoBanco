package Spring.two.demo1;




import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message  = "o ome é Obrigatorio")
    private String nome;
    private String endereco;
    @OneToMany (cascade = CascadeType.ALL)
    private List<Produto> produtos;

    public Cliente() {

    }
    public Cliente(String nome, String endereco, List<Produto> produtos) {
        this.nome = nome;
        this.endereco = endereco;
        this.produtos = produtos;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}