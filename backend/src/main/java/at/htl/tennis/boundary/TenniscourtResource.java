package at.htl.tennis.boundary;

import at.htl.tennis.control.TenniscourtService;
import at.htl.tennis.entity.Tenniscourt;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;

@GraphQLApi
public class TenniscourtResource {
    TenniscourtService tenniscourtService;

    //region constructor
    public TenniscourtResource(TenniscourtService tenniscourtService) {
        this.tenniscourtService = tenniscourtService;
    }
    //endregion

    @Query("getAllTenniscourts")
    @Description("Get all tenniscourts")
    public List<Tenniscourt> getAllTenniscourts(){return tenniscourtService.getAllTenniscourts();}

    @Query("getTenniscourtByTenniscourtId")
    @Description("Get a Tenniscourt")
    public Tenniscourt getTenniscourtByCourtId(@Name("courtId") int courtId) {return tenniscourtService.getTenniscourtByCourtId(courtId); }

}
