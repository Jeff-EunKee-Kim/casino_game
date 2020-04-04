public interface Game {
    public GameState getGameState();
    public String getGame();
    boolean isRunning();
    public void initialize();
    public void update();
    public void pause();
    public void stop();
}