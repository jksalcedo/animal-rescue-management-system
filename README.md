# Animal Rescue Management System (Refactored)

A simplified, input-based Animal Rescue Management System organized by OOP Pillars.

## Structure
The source code is organized into folders representing the 4 pillars of OOP:
- **src/abstraction/**: Interfaces (`IAdmittable`)
- **src/encapsulation/**: Core logic and base classes (`RescueSystem`, `Animal`)
- **src/inheritance/**: Concrete subclasses (`Dog`, `Cat`)
- **src/polymorphism/**: Task interfaces (`ISchedulable`, `Task`)
- **src/Main.java**: Entry point with Swing UI (`JOptionPane`).

## How to Run
1. Ensure you have Java installed.
2. Run the build script:
   ```bash
   chmod +x build.sh
   ./build.sh
   ```

## Features
- Interactive Menu (GUI Dialogs)
- Register Dogs and Cats
- Add Medical Records
- Schedule Tasks
- View Reports
