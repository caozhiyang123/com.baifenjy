package cn.itcast.web.vo;

import java.sql.Time;

public class RoundStatisticsSlot {
	
	private  String facebookId ; 
	private  String googleId ;
	private  Long userId;
	private  String time;
	private  Integer gameId;
	private  Long coins;
	private  Long xp;
	private  Integer level;
	private  Boolean isAutoPlay;
	private  Long balanceBeforeSpin;
	private  Long balanceAfterSpin;
	private  Integer bet;
	private  Integer lines;
	private  Long win;
	private  String winningPatterns;
	private  Integer isBonus;
	private  Integer bonusType;
	private  Long winBonus;
	private  Time totalRoundTime;
	private  Long totalWonOnRound;
	private  Integer mathId;
	private  String roundStatisticscol;
	private  String result;
	private  String idJogada;
	private  String status;
	private  String sessionId;
	private  String mode;
	private  Boolean isJackpot;
	private  Integer spinId;
	private  Long jackpotValue;
	private  long totalSpentOnRound;
	
	private  String platForm;
	
	
	public String getPlatForm() {
		return platForm;
	}

    public RoundStatisticsSlot(){}

    public RoundStatisticsSlot(Long userId,String facebookId,String googleId, String time, Integer gameId, Long coins, Long xp, Integer level,
			Boolean isAutoPlay, Long balanceBeforeSpin, Long balanceAfterSpin, Integer bet, Integer lines, Long win,
			String winningPatterns, Integer isBonus, Integer bonusType, Long winBonus, Time totalRoundTime,
			Long totalWonOnRound, Integer mathId, String roundStatisticscol, String result, String idJogada,
			String status, String sessionId, String mode, Boolean isJackpot, Integer spinId, Long jackpotValue, 
			Integer totalSpentOnRound,String platForm) {
		this.facebookId = facebookId; 
		this.googleId = googleId ; 
		this.userId = userId;
		this.time = time;
		this.gameId = gameId;
		this.coins = coins;
		this.xp = xp;
		this.level = level;
		this.isAutoPlay = isAutoPlay;
		this.balanceBeforeSpin = balanceBeforeSpin;
		this.balanceAfterSpin = balanceAfterSpin;
		this.bet = bet;
		this.lines = lines;
		this.win = win;
		this.winningPatterns = winningPatterns;
		this.isBonus = isBonus;
		this.bonusType = bonusType;
		this.winBonus = winBonus;
		this.totalRoundTime = totalRoundTime;
		this.totalWonOnRound = totalWonOnRound;
		this.mathId = mathId;
		this.roundStatisticscol = roundStatisticscol;
		this.result = result;
		this.idJogada = idJogada;
		this.status = status;
		this.sessionId = sessionId;
		this.mode = mode;
		this.isJackpot = isJackpot;
		this.spinId = spinId;
		this.jackpotValue = jackpotValue;
		this.totalSpentOnRound = totalSpentOnRound;
		this.platForm=platForm;
	}

    /**
     * @return the facebookId
     */
    public String getFacebookId()
    {
        return facebookId;
    }

    /**
     * @param facebookId the facebookId to set
     */
    public void setFacebookId(String facebookId)
    {
        this.facebookId = facebookId;
    }

    /**
     * @return the googleId
     */
    public String getGoogleId()
    {
        return googleId;
    }

    /**
     * @param googleId the googleId to set
     */
    public void setGoogleId(String googleId)
    {
        this.googleId = googleId;
    }

    /**
     * @return the userId
     */
    public Long getUserId()
    {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    /**
     * @return the time
     */
    public String getTime()
    {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time)
    {
        this.time = time;
    }

    /**
     * @return the gameId
     */
    public Integer getGameId()
    {
        return gameId;
    }

    /**
     * @param gameId the gameId to set
     */
    public void setGameId(Integer gameId)
    {
        this.gameId = gameId;
    }

    /**
     * @return the coins
     */
    public Long getCoins()
    {
        return coins;
    }

    /**
     * @param coins the coins to set
     */
    public void setCoins(Long coins)
    {
        this.coins = coins;
    }

    /**
     * @return the xp
     */
    public Long getXp()
    {
        return xp;
    }

    /**
     * @param xp the xp to set
     */
    public void setXp(Long xp)
    {
        this.xp = xp;
    }

    /**
     * @return the level
     */
    public Integer getLevel()
    {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(Integer level)
    {
        this.level = level;
    }

    /**
     * @return the isAutoPlay
     */
    public Boolean getIsAutoPlay()
    {
        return isAutoPlay;
    }

    /**
     * @param isAutoPlay the isAutoPlay to set
     */
    public void setIsAutoPlay(Boolean isAutoPlay)
    {
        this.isAutoPlay = isAutoPlay;
    }

    /**
     * @return the balanceBeforeSpin
     */
    public Long getBalanceBeforeSpin()
    {
        return balanceBeforeSpin;
    }

    /**
     * @param balanceBeforeSpin the balanceBeforeSpin to set
     */
    public void setBalanceBeforeSpin(Long balanceBeforeSpin)
    {
        this.balanceBeforeSpin = balanceBeforeSpin;
    }

    /**
     * @return the balanceAfterSpin
     */
    public Long getBalanceAfterSpin()
    {
        return balanceAfterSpin;
    }

    /**
     * @param balanceAfterSpin the balanceAfterSpin to set
     */
    public void setBalanceAfterSpin(Long balanceAfterSpin)
    {
        this.balanceAfterSpin = balanceAfterSpin;
    }

    /**
     * @return the bet
     */
    public Integer getBet()
    {
        return bet;
    }

    /**
     * @param bet the bet to set
     */
    public void setBet(Integer bet)
    {
        this.bet = bet;
    }

    /**
     * @return the lines
     */
    public Integer getLines()
    {
        return lines;
    }

    /**
     * @param lines the lines to set
     */
    public void setLines(Integer lines)
    {
        this.lines = lines;
    }

    /**
     * @return the win
     */
    public Long getWin()
    {
        return win;
    }

    /**
     * @param win the win to set
     */
    public void setWin(Long win)
    {
        this.win = win;
    }

    /**
     * @return the winningPatterns
     */
    public String getWinningPatterns()
    {
        return winningPatterns;
    }

    /**
     * @param winningPatterns the winningPatterns to set
     */
    public void setWinningPatterns(String winningPatterns)
    {
        this.winningPatterns = winningPatterns;
    }

    /**
     * @return the isBonus
     */
    public Integer getIsBonus()
    {
        return isBonus;
    }

    /**
     * @param isBonus the isBonus to set
     */
    public void setIsBonus(Integer isBonus)
    {
        this.isBonus = isBonus;
    }

    /**
     * @return the bonusType
     */
    public Integer getBonusType()
    {
        return bonusType;
    }

    /**
     * @param bonusType the bonusType to set
     */
    public void setBonusType(Integer bonusType)
    {
        this.bonusType = bonusType;
    }

    /**
     * @return the winBonus
     */
    public Long getWinBonus()
    {
        return winBonus;
    }

    /**
     * @param winBonus the winBonus to set
     */
    public void setWinBonus(Long winBonus)
    {
        this.winBonus = winBonus;
    }

    /**
     * @return the totalRoundTime
     */
    public Time getTotalRoundTime()
    {
        return totalRoundTime;
    }

    /**
     * @param totalRoundTime the totalRoundTime to set
     */
    public void setTotalRoundTime(Time totalRoundTime)
    {
        this.totalRoundTime = totalRoundTime;
    }

    /**
     * @return the totalWonOnRound
     */
    public Long getTotalWonOnRound()
    {
        return totalWonOnRound;
    }

    /**
     * @param totalWonOnRound the totalWonOnRound to set
     */
    public void setTotalWonOnRound(Long totalWonOnRound)
    {
        this.totalWonOnRound = totalWonOnRound;
    }

    /**
     * @return the mathId
     */
    public Integer getMathId()
    {
        return mathId;
    }

    /**
     * @param mathId the mathId to set
     */
    public void setMathId(Integer mathId)
    {
        this.mathId = mathId;
    }

    /**
     * @return the roundStatisticscol
     */
    public String getRoundStatisticscol()
    {
        return roundStatisticscol;
    }

    /**
     * @param roundStatisticscol the roundStatisticscol to set
     */
    public void setRoundStatisticscol(String roundStatisticscol)
    {
        this.roundStatisticscol = roundStatisticscol;
    }

    /**
     * @return the result
     */
    public String getResult()
    {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(String result)
    {
        this.result = result;
    }

    /**
     * @return the idJogada
     */
    public String getIdJogada()
    {
        return idJogada;
    }

    /**
     * @param idJogada the idJogada to set
     */
    public void setIdJogada(String idJogada)
    {
        this.idJogada = idJogada;
    }

    /**
     * @return the status
     */
    public String getStatus()
    {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status)
    {
        this.status = status;
    }

    /**
     * @return the sessionId
     */
    public String getSessionId()
    {
        return sessionId;
    }

    /**
     * @param sessionId the sessionId to set
     */
    public void setSessionId(String sessionId)
    {
        this.sessionId = sessionId;
    }

    /**
     * @return the mode
     */
    public String getMode()
    {
        return mode;
    }

    /**
     * @param mode the mode to set
     */
    public void setMode(String mode)
    {
        this.mode = mode;
    }

    /**
     * @return the isJackpot
     */
    public Boolean getIsJackpot()
    {
        return isJackpot;
    }

    /**
     * @param isJackpot the isJackpot to set
     */
    public void setIsJackpot(Boolean isJackpot)
    {
        this.isJackpot = isJackpot;
    }

    /**
     * @return the spinId
     */
    public Integer getSpinId()
    {
        return spinId;
    }

    /**
     * @param spinId the spinId to set
     */
    public void setSpinId(Integer spinId)
    {
        this.spinId = spinId;
    }

    /**
     * @return the jackpotValue
     */
    public Long getJackpotValue()
    {
        return jackpotValue;
    }

    /**
     * @param jackpotValue the jackpotValue to set
     */
    public void setJackpotValue(Long jackpotValue)
    {
        this.jackpotValue = jackpotValue;
    }

    /**
     * @return the totalSpentOnRound
     */
    public long getTotalSpentOnRound()
    {
        return totalSpentOnRound;
    }

    /**
     * @param totalSpentOnRound the totalSpentOnRound to set
     */
    public void setTotalSpentOnRound(long totalSpentOnRound)
    {
        this.totalSpentOnRound = totalSpentOnRound;
    }

    /**
     * @param platForm the platForm to set
     */
    public void setPlatForm(String platForm)
    {
        this.platForm = platForm;
    }

    @Override
	public String toString() {
		return "RoundStatisticsSlot [userId=" + userId + ", time=" + time + ", gameId=" + gameId + ", coins="
				+ coins + ", xp=" + xp + ", level=" + level + ", isAutoPlay=" + isAutoPlay + ", balanceBeforeSpin="
				+ balanceBeforeSpin + ", balanceAfterSpin=" + balanceAfterSpin + ", bet=" + bet + ", lines=" + lines
				+ ", win=" + win + ", winningPatterns=" + winningPatterns + ", isBonus=" + isBonus + ", bonusType="
				+ bonusType + ", winBonus=" + winBonus + ", totalRoundTime=" + totalRoundTime + ", totalWonOnRound="
				+ totalWonOnRound + ", mathId=" + mathId + ", roundStatisticscol=" + roundStatisticscol + ", result="
				+ result + ", idJogada=" + idJogada + ", status=" + status + ", sessionId=" + sessionId + ", mode="
				+ mode + ", isJackpot=" + isJackpot + ", spinId=" + spinId + ", jackpotValue=" + jackpotValue + "]";
	}
	
}
