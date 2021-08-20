package games.jjr.restaurante;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jonas on 26/04/2017.
 */

public class Restaurante implements Parcelable {
    public int codigo;
    public String nome;
    public String telefone;
    public String endereco;

    public Restaurante (int codigo, String nome, String telefone, String endereco) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Restaurante(Parcel from) {
        this.codigo = from.readInt();
        this.nome = from.readString();
        this.telefone = from.readString();
        this.endereco = from.readString();
    }

    @Override
    public String toString() {
        return this.nome + " Tel.: " + this.telefone + " \n" + endereco;
    }

    public static final Parcelable.Creator<Restaurante> CREATOR = new Parcelable.Creator<Restaurante>()
    {
        public Restaurante createFromParcel (Parcel in)
        {
            return new Restaurante(in);
        }
        public Restaurante[] newArray(int size){
            return new Restaurante[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(codigo);
        dest.writeString(nome);
        dest.writeString(telefone);
        dest.writeString(endereco);
    }
}
