package com.qf.service.impl;

import com.qf.mapper.GradeMapper;
import com.qf.mapper.StudentMapper;
import com.qf.pojo.Grade;
import com.qf.pojo.Student;
import com.qf.service.GradeManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeManagerServiceImpl implements GradeManagerService {

    @Autowired
    private GradeMapper gradeMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Grade> getGradeListByCid(int cid) {
        return gradeMapper.getGradeListByCid(cid);
    }

    @Override
    public int updateScoreBySidAndStage1(String score, int sid) {
        Student student = studentMapper.getStudentBySid(sid);
        Grade grade = gradeMapper.getGradeBySidAndCid(sid, student.getClasses().getCid());
        if (null == grade) {
            return gradeMapper.insertScoreByStage1(score, sid, student.getClasses().getCid());
        }
        return gradeMapper.updateScoreBySidAndStage1(score, sid);
    }
    @Override
    public int updateScoreBySidAndStage2(String score, int sid) {
        return gradeMapper.updateScoreBySidAndStage2(score, sid);
    }
    @Override
    public int updateScoreBySidAndStage3(String score, int sid) {
        return gradeMapper.updateScoreBySidAndStage3(score, sid);
    }
    @Override
    public int updateScoreBySidAndStage4(String score, int sid) {
        return gradeMapper.updateScoreBySidAndStage4(score, sid);
    }

    @Override
    public Grade getGradeBySid(int sid) {
        return gradeMapper.getGradeBySid(sid);
    }

    @Override
    public Grade getGradeAvgByCid(int cid) {
        return gradeMapper.getGradeAvgByCid(cid);
    }
}
