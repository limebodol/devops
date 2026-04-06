package org.cloud.controller;

import java.util.List;

import org.cloud.dto.BoardDto;
import org.cloud.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	@GetMapping("/list")
	public String openBoardList(Model model) throws Exception {
		List<BoardDto> list = boardService.selectBoardList();
		model.addAttribute("list", list);
		return "board/boardList";
	}

	@GetMapping("/write")
	public String openBoardWrite() {
		return "board/boardWrite";
	}

	@PostMapping("/insert")
	public String insertBoard(BoardDto board) throws Exception {
		board.setHitCnt(0);
		board.setDeletedYn("N");
		boardService.insertBoard(board);
		return "redirect:/board/list";
	}

	@GetMapping("/detail")
	public String openBoardDetail(@RequestParam("boardId") int boardId, Model model) throws Exception {
		boardService.updateHitCnt(boardId);
		BoardDto board = boardService.selectBoardDetail(boardId);
		model.addAttribute("board", board);
		return "board/boardDetail";
	}
}