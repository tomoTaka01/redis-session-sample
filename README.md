## Spring Boot Session Sample
  * As of 2018-01-07: Srping Boot version 1.5.9
  * using @SessionAttributes to share the User sample
  
  * HomeController.java
```java
@Controller
@SessionAttributes("user")
public class Input1Controller {
    private static final Logger logger = LoggerFactory.getLogger(Input1Controller.class);
    @ModelAttribute("genders")
    public List<String> genders() {
        return Arrays.asList("male", "female");
    }
    @PostMapping("/input1")
    public String input1(@ModelAttribute("user") User user) {
        logger.info("start input1 method user=[{}]", user.toString());
        return "input2";
    }
}
```
  