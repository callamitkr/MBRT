package com.capgemini.mbrt.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.capgemini.mbrt.model.Report;
import com.capgemini.mbrt.repository.ReportRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestReportService {

    @InjectMocks
    ReportSeviceImpl reportService;

    @Mock
    ReportRepository repository;

    @Test
    public void getAllReportsTest(){
        List<Report> reportList = new ArrayList<>();
        Report report1 = new Report(123L,"Card control1","card control desc1","barclays1","phase1");
        Report report2 = new Report(124L,"Card control2","card control desc2","barclays2","phase2");
        Report report3 = new Report(125L,"Card control3","card control desc3","barclays3","phase3");
        reportList.add(report1);
        reportList.add(report2);
        reportList.add(report3);
        when(repository.findAll()).thenReturn(reportList);

        //test
        List<Report> rlist = reportService.geAallgetReports();

        assertEquals(3, rlist.size());
        verify(repository, times(1)).findAll();

    }

    /*@Test
    public void getEmployeeByIdTest()
    {
        when(dao.getEmployeeById(1)).thenReturn(new EmployeeVO(1,"Lokesh","Gupta","user@email.com"));

        EmployeeVO emp = manager.getEmployeeById(1);

        assertEquals("Lokesh", emp.getFirstName());
        assertEquals("Gupta", emp.getLastName());
        assertEquals("user@email.com", emp.getEmail());
    }

    @Test
    public void createEmployeeTest()
    {
        EmployeeVO emp = new EmployeeVO(1,"Lokesh","Gupta","user@email.com");

        manager.addEmployee(emp);

        verify(dao, times(1)).addEmployee(emp);
    }*/

}
