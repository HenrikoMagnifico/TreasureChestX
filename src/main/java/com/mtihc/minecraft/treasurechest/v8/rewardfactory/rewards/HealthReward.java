package com.mtihc.minecraft.treasurechest.v8.rewardfactory.rewards;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

import com.mtihc.minecraft.treasurechest.v8.rewardfactory.IReward;
import com.mtihc.minecraft.treasurechest.v8.rewardfactory.RewardException;
import com.mtihc.minecraft.treasurechest.v8.rewardfactory.RewardInfo;

public class HealthReward implements IReward {

	private RewardInfo info;

	protected HealthReward(RewardInfo info) {
		this.info = info;
	}
	
	public HealthReward(double health) {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("health", health);
		this.info = new RewardInfo("health", data);
	}

	@Override
	public RewardInfo getInfo() {
		return info;
	}
	
	public double getHealth() {
		return (Integer) info.getData("health");
	}
	
	public void setHealth(double value) {
		this.info.setData("health", value);
	}

	@Override
	public String getDescription() {
		return getHealth() + " health";
	}

	@Override
	public void give(Player player) throws RewardException {
		double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
		double health = player.getHealth() + getHealth() * maxHealth / 100;
		if(health > maxHealth) {
			health = maxHealth;
		}
		else if(health < 0) {
			health = 0;
		}
		player.setHealth(health);
	}

}
