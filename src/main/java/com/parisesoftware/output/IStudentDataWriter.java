package com.parisesoftware.output;

import com.parisesoftware.dao.IStudentDataService;

public interface IStudentDataWriter {

    void output(IStudentDataService gradebook);

}
