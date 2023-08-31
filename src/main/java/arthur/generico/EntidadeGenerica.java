
package arthur.generico;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Arthur
 */
@MappedSuperclass
public abstract class EntidadeGenerica implements Serializable{
    
    public boolean ativo;
    @Temporal(TemporalType.TIMESTAMP)
    public Date dataCadastro;

    public EntidadeGenerica() {
        
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
    
}
