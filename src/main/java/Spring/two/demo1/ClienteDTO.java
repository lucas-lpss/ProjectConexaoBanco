package Spring.two.demo1;

public class ClienteDTO {

    private String endereçoCliente;

    public ClienteDTO() {
    }

    public ClienteDTO( String endereçoCliente) {

        this.endereçoCliente = endereçoCliente;
    }

    public String getEndereçoCliente() {
        return endereçoCliente;
    }

    public void setEndereçoCliente(String endereçoCliente) {
        this.endereçoCliente = endereçoCliente;
    }
}