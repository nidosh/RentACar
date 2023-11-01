package com.tobeto.a.spring.intro;
//EntitiesController
//ProductController
//CategoriesController

//Controller olarak atamak için @Restcontroller komutunu çağırmamız gerekir.
import org.springframework.web.bind.annotation.*;

@RestController
// tobeto.com/api/names
// tobeto.com/api/names/getById
// tobero.com/api/names/getByFirstLetter
@RequestMapping("api/names")
public class NamesController
{
    //Mappinglerin aynı metoda sahip olanları endpoint olarak spesifik
    // bir alan ile birbirinden ayrılmak zorundadır.
    @GetMapping
    //RequestParam ya da  QueryString ==> Parametreden bilgi okuma.
    public String get(@RequestParam String name, @RequestParam String surname )
    //public String get(@RequestParam String name, @RequestParam(required=false) String surname )
    //Eğer veriyi boş bırakmak istiyorsam required=false komutunu veriyorum.
    {
        return "Merhaba " + name + " " + surname;
    }

    // PathVariable,QueryParam
    //tek parametrelerde PathVariable, çoklu parametrelerde RequestParam tercih edilir.
    @GetMapping("get2/{name}/{surname}")
    public String get2(@PathVariable String name, @PathVariable String surname)
    {
        return "Merhaba " + name;
    }

    //JSON formatını kullanacağız.
    @PostMapping
    public String post(@RequestBody Person person)
    {
        return "Merhaba Tobeto, POST";
    }
}
