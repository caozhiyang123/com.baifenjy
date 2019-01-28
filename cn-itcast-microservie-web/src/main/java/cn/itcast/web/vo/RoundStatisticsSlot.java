package cn.itcast.web.vo;

import java.sql.Time;

public class RoundStatisticsSlot {
	
	private final String facebookId ; 
	private final String googleId ;
	private final Long userId;
	private final String time;
	private final Integer gameId;
	private final Long coins;
	private final Long xp;
	private final Integer level;
	private final Boolean isAutoPlay;
	private final Long balanceBeforeSpin;
	private final Long balanceAfterSpin;
	private final Integer bet;
	private final Integer lines;
	private final Long win;
	private final String winningPatterns;
	private final Integer isBonus;
	private final Integer bonusType;
	private final Long winBonus;
	private final Time totalRoundTime;
	private final Long totalWonOnRound;
	private final Integer mathId;
	private final String roundStatisticscol;
	private final String result;
	private final String idJogada;
	private final String status;
	private final String sessionId;
	private final String mode;
	private final Boolean isJackpot;
	private final Integer spinId;
	private final Long jackpotValue;
	private final Integer totalSpentOnRound;
	
	private final String platForm;
	
	
	public String getPlatForm() {
		return platForm;
	}

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

	public Long getUserId() {
		return userId;
	}

	public String getTime() {
		return time;
	}

	public Integer getGameId() {
		return gameId;
	}

	public Long getCoins() {
		return coins;
	}

	public Long getXp() {
		return xp;
	}

	public Integer getLevel() {
		return level;
	}

	public Boolean isAutoPlay() {
		return isAutoPlay;
	}

	public Long getBalanceBeforeSpin() {
		return balanceBeforeSpin;
	}

	public Long getBalanceAfterSpin() {
		return balanceAfterSpin;
	}

	public Integer getBet() {
		return bet;
	}

	public Integer getLines() {
		return lines;
	}

	public Long getWin() {
		return win;
	}

	public String getWinningPatterns() {
		return winningPatterns;
	}
	
	public String getWinningPatterns1() {
		return winningPatterns;
	}

	public Integer getIsBonus() {
		return isBonus;
	}

	public Integer getBonusType() {
		return bonusType;
	}

	public Long getWinBonus() {
		return winBonus;
	}

	public Time getTotalRoundTime() {
		return totalRoundTime;
	}
	
	public Time getTotalRoundTime1() {
		return totalRoundTime;
	}

	public Long getTotalWonOnRound() {
		return totalWonOnRound;
	}

	public Integer getMathId() {
		return mathId;
	}

	public String getRoundStatisticscol() {
		return roundStatisticscol;
	}
	
	public String getRoundStatisticscol1() {
		return roundStatisticscol;
	}

	public String getResult() {
		return result;
	}
	
	public String getResult1() {
		return result;
	}

	public String getIdJogada() {
		return idJogada;
	}
	
	public String getIdJogada1() {
		return  idJogada;
	}

	public String getStatus() {
		return status;
	}
	
	public String getStatus1() {
		return status;
	}

	public String getSessionId() {
		return sessionId;
	}

	public String getMode() {
		return mode;
	}
	
	public String getMode1() {
		return mode;
	}

	public Boolean isJackpot() {
		return isJackpot;
	}

	public Integer getSpinId() {
		return spinId;
	}

	public Long getJackpotValue() {
		return jackpotValue;
	}
	
	public Integer getTotalSpentOnRound() {
		return totalSpentOnRound;
	}
	public String getFacebookId()
	{
		return this.facebookId ; 
	}
	public String getGoogleId()
	
	{
		return this.googleId ; 
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
