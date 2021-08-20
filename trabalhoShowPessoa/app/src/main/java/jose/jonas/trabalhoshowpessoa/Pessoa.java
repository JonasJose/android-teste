package jose.jonas.trabalhoshowpessoa;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public class Pessoa implements Parcelable {

    private int codigo;
    private String nome;
    private String nomeCompleto;
    private String parente;
    private int idade;
    private String cidade;
    private int foto;

    public Pessoa (int codigo, String nome, String nomeCompleto, String parente, int idade, String cidade, int foto){
        this.setCodigo(codigo);
        this.setNome(nome);
        this.setNomeCompleto(nomeCompleto);
        this.setParente(parente);
        this.setIdade(idade);
        this.setCidade(cidade);
        this.setFoto(foto);
    }

    public Pessoa(Parcel from) {
        this.setCodigo(from.readInt());
        this.setNome(from.readString());
        this.setNomeCompleto(from.readString());
        this.setParente(from.readString());
        this.setIdade(from.readInt());
        this.setCidade(from.readString());
        this.setFoto(from.readInt());
    }

    public static final Parcelable.Creator<Pessoa> CREATOR = new Parcelable.Creator<Pessoa>()
    {
        public Pessoa createFromParcel (Parcel in)
        {
            return new Pessoa(in);
        }
        public Pessoa[] newArray(int size){
            return new Pessoa[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(getCodigo());
        dest.writeString(getNome());
        dest.writeString(getNomeCompleto());
        dest.writeString(getParente());
        dest.writeInt(getIdade());
        dest.writeString(getCidade());
        dest.writeInt(getFoto());
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeCompleto() { return nomeCompleto; }

    public void setNomeCompleto(String nomeCompleto) { this.nomeCompleto = nomeCompleto; }

    public String getParente() {
        return parente;
    }

    public void setParente(String parente) {
        this.parente = parente;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
