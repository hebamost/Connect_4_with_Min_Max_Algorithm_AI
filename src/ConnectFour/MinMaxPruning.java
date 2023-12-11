package ConnectFour;

public class MinMaxPruning {
    Board board = new Board() ;
    Heuristic heuristic = new Heuristic() ;
    public int nodes = 0 ;
    public State maximize(char playerTurn ,int depth ,State state ,double alpha ,double beta){
        nodes++ ;

        if (depth==0 || board.endGame(state)){
            state.setUtil(heuristic.calcHeuristic(state.board)) ;
            return state ;
        }

        State maximum = new State(state.board) ;
        maximum.setUtil(Integer.MIN_VALUE) ;

        board.children(state,playerTurn) ;

        for (State moves : state.getChildren()){
            moves.setUtil(minimize('1',depth-1,moves,alpha,beta).getUtil()) ;
            if (moves.getUtil() > maximum.getUtil()){
                maximum.setState(moves) ;
                alpha = maximum.getUtil() ;
            }
            if (beta <= alpha){
                break;
            }
        }

        return  maximum ;
    }

    public State minimize(char playerTurn ,int depth ,State state ,double alpha ,double beta){
        nodes++ ;

        if (depth==0 || board.endGame(state)){
            state.setUtil(heuristic.calcHeuristic(state.board)) ;
            return state ;
        }

        State minimum = new State(state.board) ;
        minimum.setUtil(Integer.MAX_VALUE) ;

        board.children(state,playerTurn);

        for (State moves : state.getChildren()){
            moves.setUtil(maximize('2',depth-1,moves,alpha,beta).getUtil()) ;
            if (moves.getUtil() < minimum.getUtil()){
                minimum.setState(moves);
                beta = minimum.getUtil() ;
            }
            if (beta <= alpha){
                break;
            }
        }

        return  minimum ;
    }
}
