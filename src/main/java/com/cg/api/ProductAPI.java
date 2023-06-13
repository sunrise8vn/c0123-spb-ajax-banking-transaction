package com.cg.api;


import com.cg.exception.DataInputException;
import com.cg.model.Category;
import com.cg.model.Product;
import com.cg.model.dto.ProductCreateReqDTO;
import com.cg.model.dto.ProductCreateResDTO;
import com.cg.service.category.ICategoryService;
import com.cg.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductAPI {

    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;



    @PostMapping
    public ResponseEntity<?> create(@ModelAttribute ProductCreateReqDTO productCreateReqDTO) {

        Category category = categoryService.findById(productCreateReqDTO.getCategoryId()).orElseThrow(() -> {
           throw new DataInputException("Danh mục không tồn tại");
        });

        Product product = productService.create(productCreateReqDTO, category);
        ProductCreateResDTO productCreateResDTO = product.toProductCreateResDTO();

        return new ResponseEntity<>(productCreateResDTO, HttpStatus.CREATED);
    }
}
