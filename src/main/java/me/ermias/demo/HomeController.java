package me.ermias.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    PeopleRepository peopleRepository;

    @RequestMapping("/")
    public String homePage(Model model){

        People people = new People();
        people.setName("Meron");
        people.setOccupation("Tester");
        people.setDescription("It's all about pets!!!");

        Pet pet = new Pet();
        pet.setGenre("Dogs");
        pet.setAge(6);
        pet.setDescription("It's all about dogs now!!!");

        Set<Pet> pets = new HashSet<Pet>();
        pets.add(pet);

        pet = new Pet();
        pet.setGenre("Cat");
        pet.setAge(4);
        pet.setDescription("It's all about cats from now on!!!");
        pets.add(pet);

        people.setPets(pets);
        peopleRepository.save(people);

        model.addAttribute("peoples", peopleRepository.findAll());
        return "home";
    }
}
