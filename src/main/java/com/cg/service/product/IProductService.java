package com.cg.service.product;

import com.cg.model.Category;
import com.cg.model.Product;
import com.cg.model.dto.ProductCreateReqDTO;
import com.cg.service.IGeneralService;

public interface IProductService extends IGeneralService<Product, Long> {

    Product create(ProductCreateReqDTO productCreateReqDTO, Category category);
}
