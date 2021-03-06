package com.pixelstack.ims.service;

import com.pixelstack.ims.domain.Comment;
import com.pixelstack.ims.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class CommentService {

    @Autowired
    CommentMapper commentMapper;

    public Object getCommentByiid(int iid) {
        List<Map<String,String>> commentList = commentMapper.getCommentByiid(iid);
        if (commentList == null)
            return null;
        else
            return commentList;
    }

    @Transactional
    public boolean addComment(int iid, int uid, Comment comment) {
        try {
                if (commentMapper.addComment(comment) == 0)
                    return false;
                else {
                    if (commentMapper.addCommentRelate(iid, comment.getCid()) == 0)
                        return false;
                    else
                        return true;
                }
        } catch (Exception e) {
            throw new RuntimeException("添加评论事务出错，已回滚");
        }

    }

    public boolean reportComment(int cid, boolean isReport) {
        if (commentMapper.updateReport(isReport, cid) == 0)
            return false;
        else
            return true;
    }

    public List<Map<String, Object>> getCommentWithReport() {
        List<Map<String, Object>> commentList = commentMapper.getCommentWithReport();
        if (commentList == null)
            return null;
        else
            return commentList;
    }

}
