package entities;

import entities.Resident;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-22T17:42:08")
@StaticMetamodel(Usage.class)
public class Usage_ { 

    public static volatile SingularAttribute<Usage, Date> date;
    public static volatile SingularAttribute<Usage, Integer> usageid;
    public static volatile SingularAttribute<Usage, Double> fridgeUsage;
    public static volatile SingularAttribute<Usage, Double> washmUsage;
    public static volatile SingularAttribute<Usage, Double> airconUsage;
    public static volatile SingularAttribute<Usage, Double> temperature;
    public static volatile SingularAttribute<Usage, Integer> hr;
    public static volatile SingularAttribute<Usage, Resident> resid;

}