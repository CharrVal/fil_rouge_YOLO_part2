package bll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Exception.RestaurantException;
import bo.Restaurant;
import dal.RestaurantDAO;

class RestaurantBLLTest {

    private RestaurantBLL restaurantBLL;
    private RestaurantDAO Dao;

    @BeforeEach
    void setUp() {
        Dao = new RestaurantDAO();
        restaurantBLL = new RestaurantBLL();
    }

    @Test
    void Insert_doitInsererRestaurant() throws RestaurantException {
        Restaurant restaurant = new Restaurant("Le Gourmet", "10 rue de Paris", "contact@legourmet.fr", "image.jpg", null, null, null);

        restaurantBLL.insert(restaurant);

        assertEquals(1, Dao.select().size(), "Le restaurant devrait être ajouté.");
    }

    @Test
    void Select_DoitSelectionnerToutLesRestaurants() {
        Dao.insert(new Restaurant("Resto 1", "Adresse 1", "email1@test.com", "img1.jpg", null, null, null));
        Dao.insert(new Restaurant("Resto 2", "Adresse 2", "email2@test.com", "img2.jpg", null, null, null));

        List<Restaurant> restaurants = restaurantBLL.select();

        assertEquals(2, restaurants.size(), "Deux restaurants devraient être retournés.");
    }

    @Test
    void SelectById_DoitSelectionnerUnRestaurantParId() {
        Restaurant restaurant = new Restaurant(1, "Le Bistro", "5 avenue Lyon", "contact@lebistro.fr", "bistro.jpg", null, null, null);
        Dao.insert(restaurant);

        Restaurant found = restaurantBLL.selectById(1);

        assertNotNull(found, "Le restaurant ne devrait pas être null.");
        assertEquals("Le Bistro", found.getNom());
    }

    @Test
    void Delete_DoitSupprimerRestaurant() {
        Restaurant restaurant = new Restaurant(1, "A Supprimer", "Adresse", "email@suppr.com", "img.jpg", null, null, null);
        Dao.insert(restaurant);

        restaurantBLL.delete(restaurant);

        assertEquals(0, Dao.select().size(), "Le restaurant devrait être supprimé.");
    }

    @Test
    void Update_DoitModifierRestaurant() throws RestaurantException {
        Restaurant restaurant = new Restaurant(1, "Old Name", "Adresse 1", "email@test.com", "img.jpg", null, null, null);
        Dao.insert(restaurant);

        restaurant.setNom("New Name");
        restaurantBLL.update(restaurant);
        Restaurant updatedRestaurant = restaurantBLL.selectById(1);

        assertEquals("New Name", updatedRestaurant.getNom(), "Le nom du restaurant devrait être mis à jour.");
    }
}
