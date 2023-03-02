package com.mockito.advanced.api;

import java.util.List;

public interface TodoService {
    public List<String> retrieveTodos(String user);

    void deleteToDOs(String item);
}
