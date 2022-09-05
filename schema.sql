create view order_details as select oi.id as id,
                                    oi.quantity as quantity,
                                    oi.total_price as total_price,
                                    oi.order_id as order_id,
                                    p.sku as sku,
                                    p.name as product_name,
                                    p.price as product_price,
                                    pc.name as category_name,
                                    pc.id as category_id,
                                    oi.product_id as product_id  from order_item oi
                                                                          left join products p ON p.id = oi.product_id
                                                                          left join product_orders po ON po.id = oi.order_id
                                                                          left join product_categories pc on pc.id = p.category_id