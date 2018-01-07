## Spring Boot Session Sample
  * As of 2018-01-07: Srping Boot version 1.5.9
  * using @SessionAttributes to share the User sample

### process image
  * input1,input2,input3 and inputcomplete screen use the same user attribute which is stored in redis.

  ![GitHub Logo](/images/session-flow.png)

### for redis
  * use docker compose
```
docker-compose -f docker/docker-compose.yml up
```

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

  * input1Controller.java
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

  * innput2Controller.java
```java
@Controller
@SessionAttributes("user")
public class Input2Controller {
    private static final Logger logger = LoggerFactory.getLogger(Input2Controller.class);

    @ModelAttribute("occupations")
    public List<String> occupations() {
        return Arrays.asList("teacher", "developer", "designer", "other");
    }

    @PostMapping("/input2")
    public String input2(@ModelAttribute User user) {
        logger.info("start input2 method user=[{}]", user.toString());
        return "input3";
    }
}
```

  * input3Controller.java
```java
@Controller
@SessionAttributes("user")
public class Input3Controller {
    private static final Logger logger = LoggerFactory.getLogger(Input3Controller.class);

    @PostMapping("/input3")
    public String input3(@ModelAttribute User user) {
        logger.info("start input3 method user=[{}]", user.toString());
        return "inputcomplete";
    }
}
```

  * input1.html
```html
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8"/>
    <title>input1</title>
</head>
<body>
<h3>input1</h3>
<form action="input2.html" th:action="@{/input1}" th:object="${user}" method="post">
    <div>
        <div>
            <label>User:</label>
            <input type="text" th:field="*{userName}"/>
        </div>
        <div>
            <button type="submit">next</button>
        </div>
    </div>
</form>
</body>
</html>
```

  * input2.html
```html
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8"/>
    <title>input2</title>
</head>
<body>
<h3>input2</h3>
<form action="input3.html" th:action="@{/input2}" th:object="${user}" method="post">
    <div>
        <label>User:</label>
        <span th:text="*{userName}">user</span>
    </div>
    <div>
        <label>gender:</label>
        <ul>
            <li th:each="gen: ${genders}">
                <input type="radio" th:field="*{gender}" th:value="${gen}"/>
                <label th:text="${gen}">female</label>
            </li>
        </ul>
    </div>
    <div>
        <button type="submit">next</button>
    </div>
</form>

</body>
</html>
```

  * input3.html
```html
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8"/>
    <title>input3</title>
</head>
<body>
<h3>input3</h3>
<form action="inputcomplete.html" th:action="@{/input3}" th:object="${user}" method="post">
    <div>
        <label>User:</label>
        <span th:text="*{userName}">user</span>
    </div>
    <div>
        <label>occupation:</label>
        <select th:field="*{occupation}">
            <option th:each="occ: ${occupations}"
                    th:value="${occ}"
                    th:text="${occ}">developer
            </option>
        </select>
    </div>
    <div>
        <button type="submit">next</button>
    </div>
</form>

</body>
</html>
```

  * inputcomplete.html
```html
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8"/>
    <title>input complete</title>
</head>
<body>
<h3>input complete</h3>
<div>
    <div>
        <label>User:</label>
        <span th:text="${user.userName}">user name</span>
    </div>
    <div>
        <label>gender:</label>
        <span th:text="${user.gender}">female</span>
    </div>
    <div>
        <label>occupation:</label>
        <span th:text="${user.occupation}">developer</span>
    </div>
</div>
</body>
</html>
```
