package cn.itcast.web.vo;

import org.apache.commons.lang.StringUtils;

public class RoundStatistics
{
	private Long faceBookId;
	private Long userId;//SpinHandler
	private Integer mathModleId;
	private String spinTime = null;//
	private Integer gameId;//
	private Long coins;///RoundOverHandler
	private Long xp;///
	private Integer level;///
	private Long balanceBeforeSpin;//
	private Long balanceAfterSpin;///
	private Long currentBet;//
	private Long winExtraBall;///
	private Long winBaseGame;//
	private Long spentOnExtraBall;///
	private Long spentBaseGame;//
	private Integer numberOfOpenCards;//
	private Long totalWonOnRound;///
	private Long totalSpentOnRound;///
	private String platformSignin = null;//
	private String winningPatternName = null;////CheckoutController

	private  Boolean isJackpot;
	private  int instance_id;

	private int extraBallsCount;//hava bought eb total count
	private String extraBallsPrices;//have bought every eb price in one round
	private long totalExtraBallsPrice;

	public Long getFaceBookId(){return faceBookId; }
	public void setFaceBookId(long faceBookId){this.faceBookId = faceBookId; }
	public Long getUserId()
	{
		return userId;
	}
	public void setUserId(Long userId)
	{
		this.userId = userId;
	}
    public Integer getMathModleId()
    {
        return mathModleId;
    }
    public void setMathModleId(Integer mathModleId)
    {
        this.mathModleId = mathModleId;
    }
    public String getSpinTime()
	{
		return spinTime;
	}
	public void setSpinTime(String spinTime)
	{
		this.spinTime = spinTime;
	}
	public Integer getGameId()
	{
		return gameId;
	}
	public void setGameId(Integer gameId)
	{
		this.gameId = gameId;
	}
	public Long getCoins()
	{
		return coins;
	}
	public void setCoins(Long coins)
	{
		this.coins = coins;
	}
	public Long getXp()
	{
		return xp;
	}
	public void setXp(Long xp)
	{
		this.xp = xp;
	}
	public Integer getLevel()
	{
		return level;
	}
	public void setLevel(Integer level)
	{
		this.level = level;
	}
	public Long getBalanceBeforeSpin()
	{
		return balanceBeforeSpin;
	}
	public void setBalanceBeforeSpin(Long balanceBeforeSpin)
	{
		this.balanceBeforeSpin = balanceBeforeSpin;
	}
	public Long getBalanceAfterSpin()
	{
		return balanceAfterSpin;
	}
	public void setBalanceAfterSpin(Long balanceAfterSpin)
	{
		this.balanceAfterSpin = balanceAfterSpin;
	}
	public Long getCurrentBet()
	{
		return currentBet;
	}
	public void setCurrentBet(Long currentBet)
	{
		this.currentBet = currentBet;
	}
	public Long getWinExtraBall()
	{
		return winExtraBall;
	}
	public void setWinExtraBall(Long winExtraBall)
	{
		this.winExtraBall = winExtraBall;
	}
	public Long getWinBaseGame()
	{
		return winBaseGame;
	}
	public void setWinBaseGame(Long winBaseGame)
	{
		this.winBaseGame = winBaseGame;
	}
	public Long getSpentOnExtraBall()
	{
		return spentOnExtraBall;
	}
	public void setSpentOnExtraBall(Long spentOnExtraBall)
	{
		this.spentOnExtraBall = spentOnExtraBall;
	}
	public Long getSpentBaseGame()
	{
		return spentBaseGame;
	}
	public void setSpentBaseGame(Long spentBaseGame)
	{
		this.spentBaseGame = spentBaseGame;
	}
	public Integer getNumberOfOpenCards()
	{
		return numberOfOpenCards;
	}
	public void setNumberOfOpenCards(Integer numberOfOpenCards)
	{
		this.numberOfOpenCards = numberOfOpenCards;
	}
	public Long getTotalWonOnRound()	{return totalWonOnRound;	}
	public void setTotalWonOnRound(Long totalWonOnRound)
	{
		this.totalWonOnRound = totalWonOnRound;
	}
	public Long getTotalSpentOnRound()
	{
		return totalSpentOnRound;
	}
	public void setTotalSpentOnRound(Long totalSpentOnRound)
	{
		this.totalSpentOnRound = totalSpentOnRound;
	}
	public String getPlatformSignin()
	{
		return platformSignin;
	}
	public void setPlatformSignin(String platformSignin)
	{
		this.platformSignin = platformSignin;
	}
	public String getWinningPatternName()
	{
		return winningPatternName;
	}
	public void setWinningPatternName(String winningPatternName){this.winningPatternName = winningPatternName;	}
	public Boolean getJackpot() {return isJackpot;}
	public void setJackpot(Boolean jackpot) {isJackpot = jackpot;}
	public int getInstance_id() {	return instance_id;	}
	public void setInstance_id(int instance_id) {	this.instance_id = instance_id;}
	public int getExtraBallsCount() {return extraBallsCount;}
	public void setExtraBallsCount(int extraBallsCount) {	this.extraBallsCount = extraBallsCount;}
	public String getExtraBallsPrices() {return extraBallsPrices;}
	public void setExtraBallsPrices(String extraBallsPrices) {	this.extraBallsPrices = extraBallsPrices;}
    public long getTotalExtraBallsPrice()
    {
        return totalExtraBallsPrice;
    }
    public void setTotalExtraBallsPrice(String extraBallsPrices)
    {
        String[] ebPrices = StringUtils.split(extraBallsPrices);
        int size = ebPrices.length;
        for (int i =0;i<size;i++)
        {
            totalExtraBallsPrice += Long.parseLong(ebPrices[i].replaceAll(",", ""));
        }
    }
	
}
