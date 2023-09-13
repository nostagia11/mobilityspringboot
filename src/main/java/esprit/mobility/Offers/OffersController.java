package esprit.mobility.Offers;


import esprit.mobility.Ecoles.Ecole;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/offers")
public class OffersController {


    private final OffersService offersService;

    public OffersController(OffersService offersService) {
        this.offersService = offersService;
    }

    @GetMapping
    public List<Offer> getOffers(){
        return offersService.getOffers();
    }

    @GetMapping("{id}")
    public Offer getOffer(@PathVariable("id") Long id){
       return offersService.getOffer(id);
    }

    @PostMapping("/saveoffer")
    public void createOffer(@RequestBody Offer offer){
         offersService.addNewOffer(offer);
    }

    @PutMapping("/{id}")
    public void updateOffer(@PathVariable("id") Long id,
                            @RequestBody Offer offer){
        offersService.updateOffer(id,offer);
    }

    @DeleteMapping("{id}")
    public void deleteOffer(@PathVariable Long id){
        offersService.deleteOffer(id);
    }



}
