package com.av.mychess.chessModel.boardComponents;

import com.av.mychess.CommonStructs.PlayerColor;
import com.av.mychess.Interfaces.ModelInterfaces.ICellRule;

public class LandingNotAllowedRule implements ICellRule {
    private final PlayerColor color;

    public PlayerColor getColor() {
        return color;
    }

    public LandingNotAllowedRule(PlayerColor color){
        this.color = color;
    }


    @Override
    public boolean identical(ICellRule rule) {
        if(this.getClass() == rule.getClass()){
            if(this.color == ((LandingNotAllowedRule) rule).color){
                return true;
            }
        }
        return false;
    }
}
