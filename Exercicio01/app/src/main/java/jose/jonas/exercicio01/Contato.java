package jose.jonas.exercicio01;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jonas on 02/03/2017.
 */

public class Contato implements Parcelable {
    public int id;
    public String email;
    public String telefone;

    public Contato (int id, String email, String telefone)
    {
        this.id = id;
        this.email = email;
        this.telefone = telefone;
    }

    public Contato(Parcel from) {
        this.id = from.readInt();
        this.email = from.readString();
        this.telefone = from.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(email);
        dest.writeString(telefone);
    }

    public static final Parcelable.Creator<Contato> CREATOR = new Parcelable.Creator<Contato>()
    {
        public Contato createFromParcel (Parcel in)
        {
            return new Contato(in);
        }
        public Contato[] newArray(int size){
            return new Contato[size];
        }
    };
}
