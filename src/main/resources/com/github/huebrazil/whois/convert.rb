require 'java'
require 'rubygems'
require 'whois-parser'

java_import 'com.github.huebrazil.whois.record.WhoisResult'
java_import 'com.github.huebrazil.whois.record.WhoisRegistrar'
java_import 'com.github.huebrazil.whois.record.WhoisContact'
java_import 'com.github.huebrazil.whois.record.WhoisNameserver'
java_import 'com.github.huebrazil.whois.record.WhoisPart'

def convertResponseToJava(r)
  p = r.parser
  java_registrar = nil
  if p.property_any_supported?(:registrar)
	registrar = p.registrar
    if registrar != nil
      java_registrar = WhoisRegistrar.new(registrar.id, registrar.name, registrar.organization, registrar.url)
    end
  end
  
  java_disclaimer = nil
  if p.property_any_supported?(:disclaimer)
	disclaimer = p.disclaimer
    if disclaimer != nil
      java_disclaimer = disclaimer
    end
  end
  
  java_domain = nil
  if p.property_any_supported?(:domain)
	domain = p.domain
    if disclaimer != nil
      java_domain = domain
    end
  end
  
  java_domain_id = nil
  if p.property_any_supported?(:domain_id)
	domain_id = p.domain_id
    if domain_id != nil
      java_domain_id = domain_id
    end
  end
  
  java_registrants = nil
  if p.property_any_supported?(:registrant_contacts)
	registrant_contacts = p.registrant_contacts
    if registrant_contacts != nil
      java_registrants = registrant_contacts
    end
  end
  
  java_admins = nil
  if p.property_any_supported?(:admin_contacts)
	admin_contacts = p.admin_contacts
    if admin_contacts != nil
      java_admins = admin_contacts
    end
  end
  
  java_technicals = nil
  if p.property_any_supported?(:technical_contacts)
	technical_contacts = p.technical_contacts
    if technical_contacts != nil
      java_technicals = technical_contacts
    end
  end
  
  java_created = nil
  if p.property_any_supported?(:created_on)
	created_on = p.created_on
    if created_on != nil
      java_created = created_on
    end
  end
  
  java_updated = nil
  if p.property_any_supported?(:updated_on)
	updated_on = p.updated_on
    if updated_on != nil
      java_updated = updated_on
    end
  end
  
  java_expires = nil
  if p.property_any_supported?(:expires_on)
	expires_on = p.expires_on
    if expires_on != nil
      java_expires = expires_on
    end
  end
  
  status = []
  Array(p.status).each do |s|
    status << s.to_s
  end

  return WhoisResult.new(java_disclaimer, java_domain, java_domain_id, status, p.registered?,
  p.available?, java_created, java_updated, java_expires,
  java_registrar, convertContactList(java_registrants),
  convertContactList(java_admins),
  convertContactList(java_technicals),
  convertNameserverList(p.nameservers),
  convertPartList(r.parts))
end

def createJavaContact(contact)
  java_contact = WhoisContact.new(contact.address, contact.city, contact.country,
  contact.country_code, contact.created_on, contact.email, contact.fax,
  contact.id, contact.name, contact.organization, contact.phone,
  contact.state, contact.type, contact.updated_on, contact.url, contact.zip)
  return java_contact
end

def createJavaNameserver(ns)
  return WhoisNameserver.new(ns.ipv4, ns.ipv6, ns.name)
end

def createPart(p)
  return WhoisPart.new(p.body, p.host)
end

def convertContactList(list)
  java_contacts = Array.new
  if list != nil
    list.each do |c|
      java_contacts << createJavaContact(c)
    end
  end
  return java_contacts
end

def convertNameserverList(list)
  java_ns = Array.new
  if list != nil
    list.each do |c|
      java_ns << createJavaNameserver(c)
    end
  end
  return java_ns
end

def convertPartList(list)
  java_part = Array.new
  if list != nil
    list.each do |c|
      java_part << createPart(c)
    end
  end
  return java_part
end
