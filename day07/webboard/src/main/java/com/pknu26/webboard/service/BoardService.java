package com.pknu26.webboard.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pknu26.webboard.entity.Board;
import com.pknu26.webboard.repository.BoardRepository;


@Service
// @RequiredArgsConstructor // Lombok 역할, 파라미터 생성자를 자동 생성
public class BoardService {

    // DI
    @Autowired
    private BoardRepository boardRepository;

    // @Autowired를 쓰던지, 생성자를 만들던지
    // public BoardService(BoardRepository boardRepository) {
    //     this.boardRepository = boardRepository;
    // }

    // 게시판 글 모두 가져오기
    // SELECT bno, title, content, create_date, modify_date FROM board;
    public List<Board> getBoardList() {
        return this.boardRepository.findAll();
    }

    // 게시판 글 하나 가져오기
    // SELECT bno, title, content, create_date, modify_date FROM board WHERE bno = ?;
    public Board getBoardOne(Long bno) {
        Optional<Board> opBoard = this.boardRepository.findById(bno); //Optional - null도 가지고 있는?

        if (opBoard.isPresent()) {
            return opBoard.get(); // opBoard내의 Board 객체 값 return
        } else {
            throw new RuntimeException("Board Data not found");
        }
    }

    // 게시판 글 저장
    public boolean setBoardOne(String title, String content){
        Board board = new Board();

        try{
            board.setTitle(title); // boatd.title 필드에 할당
            board.setContent(content); // board.content 필드에 할당
            board.setCreateDate(LocalDateTime.now()); // 현재 일시 할당

            // 리포지토리로 DB에 저장
            this.boardRepository.save(board); // INSERTO INTO 쿼리 실행
            return true;
        } catch (Exception e) {
            // 에러 로그 출력
            return false;
        }
        
    }

    // 게시판 글 수정
    public boolean putBoardOne(Board board, String title, String content){
        try{
            board.setTitle(title);
            board.setContent(content);
            board.setModifyDate(LocalDateTime.now());
    
            // PK bno가 있으면 save 실행 시 UPDATE 쿼리 실행
            this.boardRepository.save(board);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

        public void deleteBoardOne(Board board){
        this.boardRepository.delete(board);
    }
}