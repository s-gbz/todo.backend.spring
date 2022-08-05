# Welcome!
Welcome to this brief proof of concept that I am indeed able to use and teach Spring Boot.
This backend serves basic CRUD needs and [provides functionality](src/main/java/de/grilborzer/neuefische/todo/backend) to
- Read
- Write
- Update

[Todo items](/src/main/java/de/grilborzer/neuefische/todo/backend/persistence/Todo.java).
As described in #1, there isn't that much use from the current [test implementation](/src/test/java/de/grilborzer/neuefische/todo/backend), however this is fixable with a little more time.

## Batteries included!
You can run the application on your local machine thanks to docker-compose.
Simply run

```bash
docker-compose up -d
```

in your favourite terminal and enjoy the fun of organized todos!
PS: `-d` hides the process in the background.
You may as well omit the argument to quit the process more comfortably.