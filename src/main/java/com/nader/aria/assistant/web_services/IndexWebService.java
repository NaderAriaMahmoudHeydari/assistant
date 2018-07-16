package com.nader.aria.assistant.web_services;

import com.nader.aria.assistant.entities.enums.Menu;
import com.nader.aria.assistant.model.PageInfo;
import com.nader.aria.assistant.utils.ResponseEntityManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class IndexWebService {

    @GetMapping("/")
    public ResponseEntity<?> index(){

        PageInfo indexPage = new PageInfo();
        indexPage.setPageTitle("Index");
        indexPage.setCopyRight("@COPY; Nader Aria Company 20018-2019");
        indexPage.setMessage("Please Login in Application, or Registering New User use Menu Link. ");
        return ResponseEntityManager.UNAUTHORIZED.getResponseEntity(indexPage);
    }

    @GetMapping("/getMenuList")
    public ResponseEntity<?> getMenuList(){


        Map<String,List<String>> menuList = Stream.of(Menu.values())
                                            .collect(Collectors.toMap((m-> m.getIndex()+" : "+ m.getMenuName() +" : "+ m.getPath()),Menu::getItems));
        return ResponseEntityManager.OK.getResponseEntity(menuList);
    }
}
