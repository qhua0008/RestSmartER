package entities;

import entities.Resident;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-22T17:42:08")
@StaticMetamodel(Credential.class)
public class Credential_ { 

    public static volatile SingularAttribute<Credential, String> pwHash;
    public static volatile SingularAttribute<Credential, Date> regDate;
    public static volatile SingularAttribute<Credential, String> userName;
    public static volatile SingularAttribute<Credential, Resident> resid;

}