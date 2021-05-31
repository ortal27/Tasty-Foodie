package javaProject.tastyFoodie.react;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaProject.tastyFoodie.react.repositories.ItemRepository;
import javaProject.tastyFoodie.react.models.Item;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ReadMenuItems {
    @Autowired
    ItemRepository itemRepository;

    public void ReadDataFromJson() {
        
            ObjectMapper mapper = new ObjectMapper();
        
            try {
                List<Item> itemsList =  mapper.readValue(
                        new File("/Users/ortalsucharevich/Downloads/tastyFoodie/src/main/java/javaProject/tastyFoodie/Menu.json"),
                        new TypeReference<List<Item>>(){});
                for (int i = 0; i < itemsList.size(); i++) {
                    itemRepository.save(itemsList.get(i));
                }
                
            }
            catch(IOException e) {
                    e.printStackTrace();
            }
    }
}
