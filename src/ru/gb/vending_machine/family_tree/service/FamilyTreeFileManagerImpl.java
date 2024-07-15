package ru.gb.vending_machine.family_tree.service;





import ru.gb.vending_machine.family_tree.model.FamilyTree;
import ru.gb.vending_machine.family_tree.utils.FamilyTreeFileManager;

import java.io.*;

public class FamilyTreeFileManagerImpl implements FamilyTreeFileManager {

    @Override
    public void saveFamilyTree(FamilyTree familyTree, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(familyTree);
        }
    }

    @Override
    public FamilyTree loadFamilyTree(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (FamilyTree) ois.readObject();
        }
    }
}

