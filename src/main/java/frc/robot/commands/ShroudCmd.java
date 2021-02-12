/*----------------------------------------------------------------------------*/
/* Copyright (c) 2020 FRC Team 4639. All Rights Reserved.                     */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.ShroudSys;

import command.CommandBase;

public class ShroudCmd extends CommandBase {
	private final ShroudSys shroud;

	public ShroudCmd(ShroudSys shroud) {
		this.shroud = shroud;
		addRequirements(shroud);
	}

	@Override
	public void initialize() {
		shroud.setShroud(0.3);
	}

	public void setDesiredPosition(int pos) {
		if (pos == 0)
			shroud.setDesiredPosition(Constants.SHROUD_PRESET_0);
		else if (pos == 1)
			shroud.setDesiredPosition(Constants.SHROUD_PRESET_1);
		else if (pos == 2)
			shroud.setDesiredPosition(Constants.SHROUD_PRESET_2);
		else if (pos == 3)
			shroud.setDesiredPosition(Constants.SHROUD_PRESET_3);
	}

	@Override
	public void end(boolean interrupted) {
		shroud.setShroud(0);
	}

	@Override
	public boolean isFinished() {
		return shroud.getDegrees() > 11200;
	}
}
