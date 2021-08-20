package jose.jonas.botao;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jonas on 23/02/2017.
 */

public class Cliente implements Parcelable {
    public String nome;
    public  int codigo;

    public Cliente(String nome, int codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public static final Parcelable.Creator<Cliente> CREATOR = new Parcelable.Creator<Cliente>()
    {
        public Cliente createFromParcel (Parcel in)
        {
            return new Cliente(in);
        }
        public Cliente[] newArray(int size){
            return new Cliente[size];
        }
    };

    public Cliente(Parcel from) {
        this.nome = from.readString();
        this.codigo = from.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(codigo);
        dest.writeString(nome);
    }
}
