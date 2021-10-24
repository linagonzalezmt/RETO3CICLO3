
package com.usa.ciclo3.ciclo3.service;


import com.usa.ciclo3.ciclo3.model.Category;
import com.usa.ciclo3.ciclo3.repository.crud.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lina1
 */

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> getAll(){
        return categoryRepository.getAll();
    }
    
    public Optional<Category> getCategory(int categoryId){
        return categoryRepository.getCategory(categoryId);
    }
    
    public Category save(Category category){
        if(category.getId()==null){
            return categoryRepository.save(category);
            
        }else{
            Optional<Category> categoryAux=categoryRepository.getCategory(category.getId());
            if(categoryAux.isEmpty()){
            return categoryRepository.save(category);
        }else{
                return category;
            }
        }
    }
    
    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category> categoryAux=categoryRepository.getCategory(category.getId());
            if(!categoryAux.isEmpty()){
                if(category.getName()!=null){
                    categoryAux.get().setName(category.getName());
                }
                if(category.getDescription()!=null){
                    categoryAux.get().setDescription(category.getDescription());
                }
                return categoryRepository.save(categoryAux.get());
                }            
        }
        return category;
    }
        public boolean deleteCategory(int CategoryId){
            Boolean aBoolean = getCategory(CategoryId).map(category -> {
             categoryRepository.delete(category);
             return true;
            }).orElse(false);
            return aBoolean;
        }
    }

