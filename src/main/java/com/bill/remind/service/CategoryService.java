package com.bill.remind.service;

import com.bill.remind.entity.Category;
import com.bill.remind.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        if (category != null)
            return categoryRepository.save(category);
        else
            throw new IllegalStateException("");
    }
}
