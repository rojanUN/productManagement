package com.ProductManagementSystem.ProductManagementSystem.controller;

import com.ProductManagementSystem.ProductManagementSystem.payload.request.QueryRequest;
import com.ProductManagementSystem.ProductManagementSystem.service.QueryBuilderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/query")
@RequiredArgsConstructor
public class QueryController {

    private final QueryBuilderService queryBuilderService;

    @PostMapping("/filter/{entity}")
    public ResponseEntity<?> filterQuery (@PathVariable String entity, @RequestBody QueryRequest request){
        try {
            Class<?> entityType = Class.forName("com.ProductManagementSystem.ProductManagementSystem.entity." + entity);
            List<Object> results = queryBuilderService.executeQuery(request, entityType);
            return ResponseEntity.ok(results);
        } catch (ClassNotFoundException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
