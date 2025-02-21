package org.zerock.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.jdbcex.dao.TodoDAO;
import org.zerock.jdbcex.domain.TodoVO;

import java.time.LocalDate;
import java.util.List;

public class TodoDAOTests {

    private TodoDAO todoDAO;

    @BeforeEach
    public void ready() {
        todoDAO = new TodoDAO();
    }

    @Test
    public void testTime() throws Exception {
        System.out.println("getTime:" + todoDAO.getTime());
        System.out.println("getTime2:" + todoDAO.getTime2());
    }

    @Test
    public void testInsert() throws Exception {
        TodoVO todoVo = TodoVO.builder()
                .title("test2")
                .dueDate(LocalDate.of(2025,02,21))
                .build();

        todoDAO.insert(todoVo);
    }

    @Test
    public void testSelectAll() throws Exception {
        List<TodoVO> list = todoDAO.selectAll();

        list.forEach(vo -> System.out.println(vo));
    }

    @Test
    public void testSelectOne() throws Exception {
        Long tno = 1L;

        TodoVO vo = todoDAO.selectOne(tno);

        System.out.println(vo);
    }

    @Test
    public void testDeleteOne() throws Exception {
        Long tno = 1L;

        todoDAO.deleteOne(tno);
    }

    @Test
    public void testUpdateOne() throws Exception {
        TodoVO todoVo = TodoVO.builder()
                .tno(2L)
                .title("updateTest")
                .dueDate(LocalDate.of(2025,02,22))
                .finished(true)
                .build();

        todoDAO.updateOne(todoVo);
    }
}
