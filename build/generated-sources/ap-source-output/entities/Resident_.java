package entities;

import entities.Credential;
import entities.Usage;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-22T17:42:08")
@StaticMetamodel(Resident.class)
public class Resident_ { 

    public static volatile SingularAttribute<Resident, String> lName;
    public static volatile SingularAttribute<Resident, String> address;
    public static volatile SingularAttribute<Resident, String> fName;
    public static volatile SingularAttribute<Resident, String> provider;
    public static volatile CollectionAttribute<Resident, Usage> usageCollection;
    public static volatile SingularAttribute<Resident, Date> dob;
    public static volatile CollectionAttribute<Resident, Credential> credentialCollection;
    public static volatile SingularAttribute<Resident, String> postcode;
    public static volatile SingularAttribute<Resident, String> mobile;
    public static volatile SingularAttribute<Resident, Integer> resid;
    public static volatile SingularAttribute<Resident, String> email;
    public static volatile SingularAttribute<Resident, Integer> noOfResident;

}