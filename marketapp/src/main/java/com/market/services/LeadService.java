package com.market.services;

import java.util.List;

import com.market.entities.Lead;

public interface LeadService {
	public void saveOneLead (Lead lead);

	public List<Lead> getAllLeads();

	public void deleteLead(long id);

	public Lead updateLead(long id);
}
