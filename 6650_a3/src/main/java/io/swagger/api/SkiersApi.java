/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.35).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.LiftRide;
import io.swagger.model.ResponseMsg;
import io.swagger.model.SkierVertical;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-10-04T01:01:20.897Z[GMT]")
@Validated
public interface SkiersApi {

    @Operation(summary = "get ski day vertical for a skier", description = "get the total vertical for the skier for the specified ski day", tags={ "skiers" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation - total vertical for the day returned", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class))),
        
        @ApiResponse(responseCode = "400", description = "Invalid inputs supplied", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseMsg.class))),
        
        @ApiResponse(responseCode = "404", description = "Data not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseMsg.class))) })
    @RequestMapping(value = "/skiers/{resortID}/seasons/{seasonID}/days/{dayID}/skiers/{skierID}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Integer> getSkierDayVertical(@Parameter(in = ParameterIn.PATH, description = "ID of the resort the skier is at", required=true, schema=@Schema()) @PathVariable("resortID") Integer resortID, @Parameter(in = ParameterIn.PATH, description = "ID of the ski season", required=true, schema=@Schema()) @PathVariable("seasonID") String seasonID, @DecimalMin("1") @DecimalMax("366") @Parameter(in = ParameterIn.PATH, description = "ID number of ski day in the ski season", required=true, schema=@Schema()) @PathVariable("dayID") String dayID, @Parameter(in = ParameterIn.PATH, description = "ID of the skier riding the lift", required=true, schema=@Schema()) @PathVariable("skierID") Integer skierID);


    @Operation(summary = "get the total vertical for the skier for specified seasons at the specified resort", description = "get the total vertical for the skier the specified resort. If no season is specified, return all seasons", tags={ "skiers" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SkierVertical.class))),
        
        @ApiResponse(responseCode = "400", description = "Invalid inouts supplied", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseMsg.class))),
        
        @ApiResponse(responseCode = "404", description = "Data not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseMsg.class))) })
    @RequestMapping(value = "/skiers/{skierID}/vertical",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<SkierVertical> getSkierResortTotals(@Parameter(in = ParameterIn.PATH, description = "ID the skier to retrieve data for", required=true, schema=@Schema()) @PathVariable("skierID") Integer skierID, @NotNull @Parameter(in = ParameterIn.QUERY, description = "resort to filter by" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "resort", required = true) List<String> resort, @Parameter(in = ParameterIn.QUERY, description = "season to filter by, optional" ,schema=@Schema()) @Valid @RequestParam(value = "season", required = false) List<String> season);


    @Operation(summary = "write a new lift ride for the skier", description = "Stores new lift ride details in the data store", tags={ "skiers" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Write successful"),
        
        @ApiResponse(responseCode = "400", description = "Invalid inputs", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseMsg.class))),
        
        @ApiResponse(responseCode = "404", description = "Data not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseMsg.class))) })
    @RequestMapping(value = "/skiers/{resortID}/seasons/{seasonID}/days/{dayID}/skiers/{skierID}",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> writeNewLiftRide(@Parameter(in = ParameterIn.PATH, description = "ID of the resort the skier is at", required=true, schema=@Schema()) @PathVariable("resortID") Integer resortID, @Parameter(in = ParameterIn.PATH, description = "ID of the ski season", required=true, schema=@Schema()) @PathVariable("seasonID") String seasonID, @DecimalMin("1") @DecimalMax("366") @Parameter(in = ParameterIn.PATH, description = "ID number of ski day in the ski season", required=true, schema=@Schema()) @PathVariable("dayID") String dayID, @Parameter(in = ParameterIn.PATH, description = "ID of the skier riding the lift", required=true, schema=@Schema()) @PathVariable("skierID") Integer skierID, @Parameter(in = ParameterIn.DEFAULT, description = "Specify new Season value", required=true, schema=@Schema()) @Valid @RequestBody LiftRide body);

}

