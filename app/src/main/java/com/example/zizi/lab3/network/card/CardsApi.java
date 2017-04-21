package com.example.zizi.lab3.network.card;

import java.util.List;

import com.example.zizi.lab3.model.Card;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CardsApi {
  /**
   * Cards
   * Returns all cards from the system. 
   * @return Call&lt;List<Card>&gt;
   */
  
  @GET("card")
  Call<List<Card>> cardGet();
    

  /**
   * Card
   * Removes a card from the system. 
   * @param id Id of the card to delete (required)
   * @return Call&lt;Void&gt;
   */
  
  @DELETE("card/{id}")
  Call<Void> cardIdDelete(
    @Path("id") Double id
  );

  /**
   * Card
   * Returns a single card from the system. 
   * @param id Id of the card to fetch (required)
   * @return Call&lt;Card&gt;
   */
  
  @GET("card/{id}")
  Call<Card> cardIdGet(
    @Path("id") Double id
  );

  /**
   * Card
   * Updates a card in the system. 
   * @param id Id of the card to update (required)
   * @param card Card object to update in the system (required)
   * @return Call&lt;Void&gt;
   */
  
  @PUT("card/{id}")
  Call<Void> cardIdPut(
    @Path("id") Double id, @Body Card card
  );

  /**
   * Card
   * Inserts a card to the system.
   * @param card Card object to update in the system (required)
   * @return Call&lt;Void&gt;
   */
  
  @POST("card")
  Call<Void> cardPost(
    @Body Card card
  );

}
