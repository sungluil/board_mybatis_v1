package com.example.board_mybatis_v1.controller;

import com.example.board_mybatis_v1.domain.BoardMybatis;
import com.example.board_mybatis_v1.repository.BoardMybatisRepository;
import com.example.board_mybatis_v1.service.BoardService;
import com.tobesoft.xplatform.data.DataSet;
import com.tobesoft.xplatform.data.DataTypes;
import com.tobesoft.xplatform.data.PlatformData;
import com.tobesoft.xplatform.data.VariableList;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardController {

    private final BoardService boardService;
    private final BoardMybatisRepository boardMybatisRepository;


    @GetMapping("/findAll")
    public List<BoardMybatis> getBoard() {


        List<BoardMybatis> all = boardService.findAll();

        if (all.size() == 0) {
            throw new IllegalArgumentException("error");
        }

        return boardService.findAll();
    }

    @GetMapping("/insert")
    public void insert() {
        boardService.insert();
    }


    @GetMapping("/xplatform")
    public void xplatform() {

        DataSet ds = new DataSet("customers");
        ds.addColumn("id",DataTypes.INT);
        ds.addColumn("name",DataTypes.STRING, 16);
        ds.addColumn("email", DataTypes.STRING, 32);
        ds.addColumn("birthday", DataTypes.STRING, 8);
        ds.addColumn("phone", DataTypes.STRING, 16);
        ds.addColumn("home_addr", DataTypes.STRING, 256);
        ds.addColumn("company", DataTypes.STRING, 32);
        ds.addColumn("jobtitle", DataTypes.STRING, 32);
        ds.addColumn("busi_phone", DataTypes.STRING, 16);
        ds.addColumn("busi_addr", DataTypes.STRING, 256);

        int row = 0;
        row = ds.newRow();
        ds.set(row,"id", "id");
        ds.set(row,"name", "name");
        ds.set(row,"email", "email");
        ds.set(row,"birthday", "birthday");
        ds.set(row,"phone", "phone");
        ds.set(row,"home_addr", "homeAddr");
        ds.set(row,"company", "company");
        ds.set(row,"jobtitle", "jobtitle");
        ds.set(row,"busi_phone", "phone");
        ds.set(row,"busi_addr", "addr");

        PlatformData platformData = new PlatformData();

        DataSet dataSet = new DataSet("aa");
        dataSet.addColumn("aa", DataTypes.STRING);
        int i = dataSet.newRow();
        dataSet.set(i, "aa", "stussy");

        platformData.addDataSet(dataSet);

        System.out.println(platformData.getDataSet(0).getObject(0, "aa"));

        VariableList variableList = platformData.getVariableList();
        variableList.add("ErrorCode", "에러안났어요");

        System.out.println(platformData.getVariableList().getObject("ErrorCode"));
        System.out.println(platformData.getDataSetList().get("aa").getRowCount());

    }
}
