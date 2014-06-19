require 'rubygems'
require 'whois'
require 'java'

import 'uk.bl.wa.whois.record.WhoisResult'
import 'uk.bl.wa.whois.record.WhoisRegistrar'
import 'uk.bl.wa.whois.record.WhoisContact'
import 'uk.bl.wa.whois.record.WhoisNameserver'
import 'uk.bl.wa.whois.record.WhoisPart'

# Set up a client
w = Whois::Client.new(timeout: timeout_param)

# Lookup the domain
r = w.lookup(domain)

registrar = r.registrar
java_registrar = nil

if registrar != nil
  java_registrar = WhoisRegistrar.new(registrar.id, registrar.name, registrar.organization, registrar.url)
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

status = []
Array(r.status).each do |s|
  status << s.to_s
end

puts r.contacts.count
puts r.contacts

WhoisResult.new(r.disclaimer, r.domain, r.domain_id, status, r.registered?,
r.available?, r.created_on, r.updated_on, r.expires_on,
java_registrar, convertContactList(r.registrant_contacts),
convertContactList(r.admin_contacts),
convertContactList(r.technical_contacts),
convertNameserverList(r.nameservers),
convertPartList(r.parts))

