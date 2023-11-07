
class Usuario{
    private long id;
    private String login, email, nome, afiliacao;

    public Usuario(long id, String login, String email, String nome, String afiliacao) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.nome = nome;
        this.afiliacao = afiliacao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAfiliacao() {
        return afiliacao;
    }

    public void setAfiliacao(String afiliacao) {
        this.afiliacao = afiliacao;
    }
}