package cn.itcast.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.itcast.web.config.DruidConfig;
import cn.itcast.web.vo.RoundStatistics;
import cn.itcast.web.vo.RoundStatisticsSlot;

@Repository
public class RtpDao
{
    private final static Logger logger = LoggerFactory.getLogger(RtpDao.class);
    
    public final static  String TABLE_NAME = "round_statistics";//
    public final static  String USER_ID = "user_id";
    public final static  String SPIN_TIME = "time";
    public final static  String GAME_ID = "game_id";
    public final static  String COINS = "coins";
    public final static  String XP = "xp";
    public final static  String LEVEL = "level";
    public final static  String BALANCE_BEFORE_SPIN = "balance_before_spin";
    public final static  String BALANCE_AFTER_SPIN = "balance_after_spin";
    public final static  String CURRENT_BET = "bet";
    public final static  String WIN_EXTRA_BALL = "win_extra_ball";
    public final static  String WIN_BASE_GAME = "win_base_game";
    public final static  String SPENT_ON_EXTRA_BALL = "spent_on_extra_ball";
    public final static  String SPENT_BASE_GAME = "spent_base_game";
    public final static  String NUMBER_OF_OPEN_CARDS = "number_of_open_cards";
    public final static  String TOTAL_WON_ON_ROUND = "total_won_on_round";
    public final static  String TOTAL_SPENT_ON_ROUND = "total_spent_on_round";
    public final static  String PLATFORM_SIGNIN = "platform";
    public final static  String WINNING_PATTERN_NAME = "winning_prizes";//
    public final static  String MATH_MODEL_ID = "math_id";//
    public final static  String INSTANCE_ID = "instance_id";//
    public final static  String IS_JACKPOT_WIN = "is_jackpot";//

    public final static String EXTRA_BALLS_COUNT ="extra_balls_count";
    public final static String EXTRA_BALLS_PRICES ="extra_balls_prices";


    public final static String USER_BINGO_STATISTICS = "user_bingo_statistics";
    public final static String JACKPOT_WIN = "jackpot_value";
    public final static String BALLS_INDEX = "balls_index";
    
    public final static  String TABLE_NAME_SLOT = "round_statistics_slot";
    
    @Autowired
    DruidConfig druidConfig;

    public List<RoundStatistics> queryVbRtpByGameId(int gameId, String timeFrom, String timeTo)
    {
        List<RoundStatistics> roundStatistics = new ArrayList<RoundStatistics>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try
        {
            conn = druidConfig.dataSource().getConnection();
            String sql = String.format("select * from %s where %s = ? and %s >= ? and %s <= ?",TABLE_NAME,GAME_ID,SPIN_TIME,SPIN_TIME );
            pst = conn.prepareStatement(sql);
            pst.setInt(1, gameId);
            pst.setString(2, timeFrom);
            pst.setString(3, timeTo);
            rst = pst.executeQuery();
            while(rst.next()){
                RoundStatistics roundStatistic = new RoundStatistics();
                roundStatistic.setGameId(gameId);
                roundStatistic.setTotalWonOnRound(rst.getLong(TOTAL_WON_ON_ROUND));
                roundStatistic.setTotalSpentOnRound(rst.getLong(TOTAL_SPENT_ON_ROUND));
                roundStatistic.setWinBaseGame(rst.getLong(WIN_BASE_GAME));
                roundStatistic.setWinExtraBall(rst.getLong(WIN_EXTRA_BALL));
                roundStatistic.setSpentBaseGame(rst.getLong(SPENT_BASE_GAME));
                roundStatistic.setSpentOnExtraBall(rst.getLong(SPENT_ON_EXTRA_BALL));
                roundStatistic.setExtraBallsCount(rst.getInt(EXTRA_BALLS_COUNT));
                roundStatistic.setCurrentBet((long)rst.getInt(CURRENT_BET));
                roundStatistic.setExtraBallsPrices(rst.getString(EXTRA_BALLS_PRICES));
                roundStatistic.setTotalExtraBallsPrice(roundStatistic.getExtraBallsPrices());
                roundStatistics.add(roundStatistic);
            }
            return roundStatistics;
        } catch (SQLException e)
        {
            e.printStackTrace();
            logger.error("queryVbRtpByGameId error:"+e);
        }finally{
            druidConfig.release(conn, pst, rst);
        }
        return roundStatistics;
    }

    public List<RoundStatisticsSlot> querySlotRtpByGameId(int gameId, String timeFrom, String timeTo)
    {
        List<RoundStatisticsSlot> roundStatistics = new ArrayList<RoundStatisticsSlot>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try
        {
            conn = druidConfig.dataSource().getConnection();
            String sql = String.format("select * from %s where %s = ? and %s >= ? and %s <= ?",TABLE_NAME_SLOT,GAME_ID,SPIN_TIME,SPIN_TIME );
            pst = conn.prepareStatement(sql);
            pst.setInt(1, gameId);
            pst.setString(2, timeFrom);
            pst.setString(3, timeTo);
            rst = pst.executeQuery();
            while(rst.next()){
                RoundStatisticsSlot roundStatistic = new RoundStatisticsSlot();
                roundStatistic.setGameId(rst.getInt(GAME_ID));
                roundStatistic.setTotalWonOnRound(rst.getLong(TOTAL_WON_ON_ROUND));
                roundStatistic.setTotalSpentOnRound(rst.getLong(TOTAL_SPENT_ON_ROUND));
                roundStatistic.setBet(rst.getInt(CURRENT_BET));
                roundStatistics.add(roundStatistic);
            }
            return roundStatistics;
        } catch (SQLException e)
        {
            e.printStackTrace();
            logger.error("queryVbRtpByGameId error:"+e);
        }finally{
            druidConfig.release(conn, pst, rst);
        }
        return roundStatistics;
    }

    public long queryUserCountByTime(int gameId, String timeFrom, String timeTo)
    {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try
        {
            conn = druidConfig.dataSource().getConnection();
            String sql = String.format("select count(DISTINCT %s) from %s where %s = ? and %s >= ? and %s <=?",USER_ID,TABLE_NAME,GAME_ID,SPIN_TIME,SPIN_TIME);
            pst = conn.prepareStatement(sql);
            pst.setLong(1, gameId);
            pst.setString(2, timeFrom);
            pst.setString(3, timeTo);
            rst = pst.executeQuery();
            while(rst.next()){
                return rst.getInt(1);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            logger.error("queryUserCountByTime error:"+e);
        }finally{
            druidConfig.release(conn, pst, rst);
        }
        
        return 0;
    }

    public int querJackpotCountByTime(int gameId, String timeFrom, String timeTo)
    {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try
        {
            conn = druidConfig.dataSource().getConnection();
            String sql = String.format("select count(*) from %s where %s = ? and %s >= ? and %s <=?",USER_BINGO_STATISTICS,GAME_ID,SPIN_TIME,SPIN_TIME);
            pst = conn.prepareStatement(sql);
            pst.setLong(1, gameId);
            pst.setString(2, timeFrom);
            pst.setString(3, timeTo);
            rst = pst.executeQuery();
            while(rst.next()){
                return rst.getInt(1);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            logger.error("queryUserCountByTime error:"+e);
        }finally{
            druidConfig.release(conn, pst, rst);
        }
        return 0;
    }

    public long queryUserCountByTimeOfSlot(int gameId, String timeFrom, String timeTo)
    {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try
        {
            conn = druidConfig.dataSource().getConnection();
            String sql = String.format("select count(DISTINCT %s) from %s where %s = ? and %s >= ? and %s <=?",USER_ID,TABLE_NAME_SLOT,GAME_ID,SPIN_TIME,SPIN_TIME);
            pst = conn.prepareStatement(sql);
            pst.setLong(1, gameId);
            pst.setString(2, timeFrom);
            pst.setString(3, timeTo);
            rst = pst.executeQuery();
            while(rst.next()){
                return rst.getInt(1);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            logger.error("queryUserCountByTime error:"+e);
        }finally{
            druidConfig.release(conn, pst, rst);
        }
        
        return 0;
    }
    
    
    
}
