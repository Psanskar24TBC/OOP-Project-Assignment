# TurtleGraphics Java Project

This project is a graphical drawing tool developed using **Java Swing** and the **LBUGraphics** library. It simulates turtle graphics and supports both standard and custom drawing commands through a text interface.

---

## How to Run the Project

1. Open the project in **Eclipse** or any Java IDE.
2. Ensure `LBUGraphics.jar` is added to the classpath.
3. Compile and run:
   - `Main.java` (for basic version)
   - OR `TurtleGraphic2025.java` (for full-featured version)

---

## Core Features Implemented

- ✅ Save image (as `.png`) using `screenshot` command
- ✅ Load and display external image using `image`
- ✅ Save typed commands to a text file using `save`
- ✅ Load and auto-execute commands using `load`
- ✅ GUI Dialogues with `JFileChooser` and `JOptionPane`
- ✅ Override `about()` to include your name
- ✅ Supports drawing with commands:
  - `turtleMove <pixels>`
  - `reverse <pixels>`
  - `left <degrees>`
  - `right <degrees>`
  - `penUp`, `penDown`
  - `penwidth <size>`
  - `pencolor <r> <g> <b>`
  - `square <side>`
  - `triangle <a> <b> <c>`
  - `equilateral <side>`
  - `clear`, `reset`, `about`

---

## Bonus Features

- `randomcolor` — Sets pen color to a random RGB value
- `doublewidth` — Doubles the current pen width
- `circle` — Draws a circular shape
- `clock` — Draws a clock-like decorative figure
- `name` — Custom method to draw "SANSKAR" using turtle graphics
- `shape` — Composite shape combining multiple figures

---

## Author

**Sanskar Paudel**  
OOP Project, 2025  
Based on the LBUGraphics Framework from Leeds Beckett University

---

## 📁 Project Structure

```
Java_Project2025/
├── src/
│   └── OOP2025/
│       ├── Main.java
│       └── TurtleGraphic2025.java
├── bin/
├── .classpath
├── .project
└── LBUGraphics.jar
```

---

## 📌 Notes

- The application automatically checks for valid parameters.
- Errors (e.g., negative input, invalid RGB) are handled with GUI warnings.
- Saved command files can be reloaded and replayed.

