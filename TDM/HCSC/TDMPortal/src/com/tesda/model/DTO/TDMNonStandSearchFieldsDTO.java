package com.tesda.model.DTO;

import java.util.Set;

public class TDMNonStandSearchFieldsDTO
{

	private Set<String> claimTypes;
	private Set<String> planTypes;
	private Set<String> memCatagories;
	private Set<String> coverageTypes;
	private Set<String> memStatus;
	private Set<String> stateTypes;
	private Set<String> subscRelations;
	private Set<String> ageGroups;

	public Set<String> getClaimTypes()
	{
		return claimTypes;
	}

	public void setClaimTypes(Set<String> claimTypes)
	{
		this.claimTypes = claimTypes;
	}

	public Set<String> getPlanTypes()
	{
		return planTypes;
	}

	public void setPlanTypes(Set<String> planTypes)
	{
		this.planTypes = planTypes;
	}

	public Set<String> getMemCatagories()
	{
		return memCatagories;
	}

	public void setMemCatagories(Set<String> memCatagories)
	{
		this.memCatagories = memCatagories;
	}

	public Set<String> getCoverageTypes()
	{
		return coverageTypes;
	}

	public void setCoverageTypes(Set<String> coverageTypes)
	{
		this.coverageTypes = coverageTypes;
	}

	public Set<String> getMemStatus()
	{
		return memStatus;
	}

	public void setMemStatus(Set<String> memStatus)
	{
		this.memStatus = memStatus;
	}

	public Set<String> getStateTypes()
	{
		return stateTypes;
	}

	public void setStateTypes(Set<String> stateTypes)
	{
		this.stateTypes = stateTypes;
	}

	public Set<String> getSubscRelations()
	{
		return subscRelations;
	}

	public void setSubscRelations(Set<String> subscRelations)
	{
		this.subscRelations = subscRelations;
	}

	public Set<String> getAgeGroups()
	{
		return ageGroups;
	}

	public void setAgeGroups(Set<String> ageGroups)
	{
		this.ageGroups = ageGroups;
	}
}
